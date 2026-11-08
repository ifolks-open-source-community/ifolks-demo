import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { I18nService } from './I18nService';
import { i18nConfig } from './i18n.config';

describe('I18nService', () => {
  let service: I18nService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    localStorage.clear();
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [I18nService],
    });
    service = TestBed.inject(I18nService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
    localStorage.clear();
  });

  it('should initialize with default en_US locale from i18nConfig', async () => {
    localStorage.setItem('locale', 'en_US');
    const initPromise = service.init(i18nConfig);

    const modelReq = httpMock.expectOne('assets/i18n/model.json');
    const mainReq = httpMock.expectOne('assets/i18n/main.json');
    modelReq.flush({ countryList: 'Countries' });
    mainReq.flush({ save: 'Save' });

    await initPromise;

    expect(service.getLocale()).toBe('en_US');
    expect(service.getCurrentLocaleLabel()).toBe('English (US)');
    expect(service.translate('countryList')).toBe('Countries');
    expect(service.translate('save')).toBe('Save');
  });

  it('should load French overlay when locale is fr_FR', async () => {
    localStorage.setItem('locale', 'fr_FR');
    const initPromise = service.init(i18nConfig);

    const modelReq = httpMock.expectOne('assets/i18n/model.json');
    const mainReq = httpMock.expectOne('assets/i18n/main.json');
    const modelFrReq = httpMock.expectOne('assets/i18n/model_fr_FR.json');
    const mainFrReq = httpMock.expectOne('assets/i18n/main_fr_FR.json');

    modelReq.flush({ countryList: 'Countries', countryCode: 'ISO Code' });
    mainReq.flush({ save: 'Save' });
    modelFrReq.flush({ countryList: 'Pays' });
    mainFrReq.flush({ save: 'Enregistrer' });

    await initPromise;

    expect(service.getLocale()).toBe('fr_FR');
    expect(service.getCurrentLocaleLabel()).toBe('Français (France)');
    expect(service.translate('countryList')).toBe('Pays');
    expect(service.translate('countryCode')).toBe('ISO Code');
    expect(service.translate('save')).toBe('Enregistrer');
  });
});
