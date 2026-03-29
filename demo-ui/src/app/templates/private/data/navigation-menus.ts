import { NavMenu } from '../models/nav-menu';

export const navigationMenus: NavMenu[] = [

  {
    text: 'Reference',
    links:[
      {
        text: 'Countries',
        path: '/country/list'
      },
      {
        text: 'Regions',
        path: '/region/list'
      },
      {
        text: 'Cities',
        path: '/city/list'
      }
    ]
  },

  {
    text:'Organizations',
    path:'/organization/list'
  },

  {
    text:'Calendars',
    path:'/calendar/list'
  },

  {
    text: 'Dummies',
    links:[
      {
        text: 'Fools',
        path: '/fool/list'
      },
      {
        text: 'Stupids',
        path: '/stupid/list'
      }
    ]
  }
];