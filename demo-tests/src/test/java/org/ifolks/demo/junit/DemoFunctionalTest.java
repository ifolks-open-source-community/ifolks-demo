package org.ifolks.demo.junit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.ifolks.commons.api.exception.repository.ResourceNotFoundException;
import org.ifolks.commons.api.model.OrderType;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import org.ifolks.demo.api.interfaces.dummy.FoolService;
import org.ifolks.demo.api.interfaces.dummy.StupidService;
import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.interfaces.reference.localization.CityService;
import org.ifolks.demo.api.interfaces.reference.localization.CountryService;
import org.ifolks.demo.api.interfaces.reference.localization.RegionService;
import org.ifolks.demo.api.interfaces.reference.time.CalendarService;
import org.ifolks.demo.api.model.dummy.enums.FoolStatus;
import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.api.model.dummy.views.basic.FoolBasicView;
import org.ifolks.demo.api.model.dummy.views.full.FoolFullView;
import org.ifolks.demo.api.model.dummy.views.full.StupidFullView;
import org.ifolks.demo.api.model.organizations.enums.OrganizationRole;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.ifolks.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.CityFullView;
import org.ifolks.demo.api.model.reference.localization.views.full.CountryFullView;
import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarFullView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(ApplicationConfig.class)
public class DemoFunctionalTest {

	@Autowired
	private JUnitDataInitializer dataInitializer;

	@Autowired
	private CountryService countryService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private CityService cityService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private CalendarService calendarService;

	@Autowired
	private FoolService foolService;

	@Autowired
	private StupidService stupidService;

	@BeforeEach
	public void setUp() {
		dataInitializer.initialize();
	}

	@Test
	public void testLocalizationCrudAndScroll() {
		// 1. Country: options, find, save, update, delete
		List<SelectItem> options = countryService.getOptions();
		assertEquals(1, options.size());
		assertEquals("FR", options.get(0).key());
		assertEquals("France", options.get(0).label());

		CountryFullView france = countryService.find("FR");
		assertNotNull(france);
		assertEquals("FR", france.form().code());
		assertEquals("France", france.form().label());

		Short belgiumId = countryService.save(new CountryForm("BE", "Belgique"));
		assertNotNull(belgiumId);
		assertEquals(2, countryService.loadList().size());

		countryService.update(belgiumId, new CountryForm("BE", "Belgium"));
		CountryFullView belgium = countryService.load(belgiumId);
		assertEquals("Belgium", belgium.form().label());

		countryService.delete(belgiumId);
		assertEquals(1, countryService.loadList().size());
		assertThrows(ResourceNotFoundException.class, () -> countryService.load(belgiumId));

		// 2. Region: pagination, sorting, and accent-insensitive filter (UNACCENT)
		List<RegionBasicView> allRegions = regionService.loadList();
		assertEquals(27, allRegions.size());

		RegionFilter filter = new RegionFilter();
		RegionSorting sorting = new RegionSorting();
		sorting.setCodeOrderType(OrderType.DESC);
		ScrollView<RegionBasicView> page1 = regionService.scroll(new ScrollForm<>(filter, sorting, 1L, 10L));
		assertEquals(27L, page1.size());
		assertEquals(27L, page1.count());
		assertEquals(3L, page1.numberOfPages());
		assertEquals(10, page1.elements().size());
		assertEquals("94", page1.elements().get(0).code());

		// Filter without accents ("ile-de-france" should match "Île-de-France")
		filter.setLabel("bret");
		ScrollView<RegionBasicView> filtered = regionService.scroll(new ScrollForm<>(filter, sorting, 1L, 10L));
		assertEquals(1L, filtered.count());
		assertEquals("53", filtered.elements().get(0).code());
		assertEquals("Bretagne", filtered.elements().get(0).label());

		// 3. City: find by composite parent keys and CRUD
		List<CityBasicView> cities = cityService.loadList();
		assertEquals(4, cities.size());

		CityFullView amberieu = cityService.find("FR", "82", "01004");
		assertEquals("Ambérieu-en-Bugey", amberieu.form().label());

		Long lyonId = cityService.save(new CityForm("FR", "82", "69001", "Lyon 1er"));
		assertNotNull(lyonId);
		assertEquals(5, cityService.loadList().size());

		cityService.update(lyonId, new CityForm("FR", "82", "69001", "Lyon"));
		assertEquals("Lyon", cityService.load(lyonId).form().label());

		cityService.delete(lyonId);
		assertEquals(4, cityService.loadList().size());
	}

	@Test
	public void testOrganizationAndOneToOneComponents() {
		List<OrganizationBasicView> orgs = organizationService.loadList();
		assertEquals(3, orgs.size());

		List<SelectItem> matches = organizationService.searchOptions("ACME");
		assertEquals(3, matches.size());

		// Verify embedded OneToOne component (OrganizationDescription) populated from CSV
		OrganizationFullView acme = organizationService.find("ACME");
		assertNotNull(acme);
		assertEquals(OrganizationRole.HEADQUARTERS, acme.form().role());
		assertEquals("ACME Corp HQ", acme.form().description());

		// Verify non-embedded OneToOne component lifecycle (OrganizationCertification)
		organizationService.saveOrganizationCertification(acme.id(), new OrganizationCertificationForm(true));
		OrganizationCertificationFullView cert = organizationService.loadOrganizationCertification(acme.id());
		assertNotNull(cert);
		assertTrue(cert.form().certified());

		organizationService.updateOrganizationCertification(acme.id(), new OrganizationCertificationForm(false));
		cert = organizationService.loadOrganizationCertification(acme.id());
		assertFalse(cert.form().certified());

		organizationService.deleteOrganizationCertification(acme.id());
		cert = organizationService.loadOrganizationCertification(acme.id());
		assertNull(cert);

		// Create, update, delete Organization with embedded description
		Integer newOrgId = organizationService.save(
				new OrganizationForm("IFOLKS", OrganizationRole.HEADQUARTERS, "iFolks Open Source"));
		OrganizationFullView ifolks = organizationService.load(newOrgId);
		assertEquals("iFolks Open Source", ifolks.form().description());

		organizationService.update(newOrgId,
				new OrganizationForm("IFOLKS", OrganizationRole.SUBSIDIARY, "iFolks Updated"));
		assertEquals("iFolks Updated", organizationService.load(newOrgId).form().description());
		assertEquals(OrganizationRole.SUBSIDIARY, organizationService.load(newOrgId).form().role());

		organizationService.delete(newOrgId);
		assertEquals(3, organizationService.loadList().size());
	}

	@Test
	public void testCalendarAndOneToManyComponents() {
		CalendarFullView frCalendar = calendarService.find("FR");
		assertNotNull(frCalendar);
		assertEquals("French Calendar", frCalendar.form().label());

		List<CalendarDayOffBasicView> daysOff = calendarService.loadCalendarDayOffList(frCalendar.id());
		assertEquals(2, daysOff.size());

		ScrollView<CalendarDayOffBasicView> scrolledDaysOff = calendarService.scrollCalendarDayOff(
				frCalendar.id(), new ScrollForm<>(new CalendarDayOffFilter(), new CalendarDayOffSorting(), 1L, 10L));
		assertEquals(2L, scrolledDaysOff.count());

		// Add, update, and delete a OneToMany CalendarDayOff component
		LocalDate bastilleDay = LocalDate.of(2026, 7, 14);
		calendarService.saveCalendarDayOff(frCalendar.id(), new CalendarDayOffForm(bastilleDay, "Bastille Day"));

		daysOff = calendarService.loadCalendarDayOffList(frCalendar.id());
		assertEquals(3, daysOff.size());

		CalendarDayOffBasicView added = daysOff.stream()
				.filter(d -> bastilleDay.equals(d.dayOffDate()))
				.findFirst()
				.orElseThrow();
		assertEquals("Bastille Day", added.dayOffLabel());

		calendarService.updateCalendarDayOff(added.id(), new CalendarDayOffForm(bastilleDay, "Fête Nationale"));
		CalendarDayOffFullView loadedDayOff = calendarService.loadCalendarDayOff(added.id());
		assertEquals("Fête Nationale", loadedDayOff.form().dayOffLabel());

		calendarService.deleteCalendarDayOff(added.id());
		assertEquals(2, calendarService.loadCalendarDayOffList(frCalendar.id()).size());
	}

	@Test
	public void testDummyTypesAndRelationships() {
		LocalDate today = LocalDate.of(2026, 11, 8);
		OffsetDateTime now = OffsetDateTime.of(2026, 11, 8, 12, 0, 0, 0, ZoneOffset.UTC);

		FoolForm foolForm = new FoolForm(
				"FOOL-1",
				"First Fool",
				FoolStatus.ACTIVE,
				"Testing all field types",
				42L,
				true,
				3.14,
				new BigDecimal("99.95"),
				today,
				now);

		String foolId = foolService.save(foolForm);
		assertNotNull(foolId);

		FoolFullView loadedFool = foolService.load(foolId);
		assertEquals("FOOL-1", loadedFool.form().code());
		assertEquals(FoolStatus.ACTIVE, loadedFool.form().status());
		assertEquals(42L, loadedFool.form().longField());
		assertTrue(loadedFool.form().booleanField());
		assertEquals(0, new BigDecimal("99.95").compareTo(loadedFool.form().decimalField()));
		assertEquals(today, loadedFool.form().dateField());

		// Filter Fool by status, boolean, and date range
		FoolFilter filter = new FoolFilter();
		filter.setStatus(FoolStatus.ACTIVE);
		filter.setBooleanField(true);
		filter.setDateFieldMinValue(today.minusDays(1));
		filter.setDateFieldMaxValue(today.plusDays(1));
		ScrollView<FoolBasicView> scrolled = foolService.scroll(new ScrollForm<>(filter, new FoolSorting(), 1L, 10L));
		assertEquals(1L, scrolled.count());
		assertEquals("FOOL-1", scrolled.elements().get(0).code());

		// Create and verify Stupid linked to Fool
		Long stupidId = stupidService.save(new StupidForm("STUPID-1", "FOOL-1"));
		assertNotNull(stupidId);

		StupidFullView loadedStupid = stupidService.find("STUPID-1");
		assertEquals("FOOL-1", loadedStupid.form().foolCode());

		stupidService.delete(stupidId);
		foolService.delete(foolId);
		assertEquals(0, foolService.loadList().size());
	}
}
