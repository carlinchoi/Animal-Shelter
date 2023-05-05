
const routes = [
  {
    name: 'homePage',
    path: '/',
    component: () => import('pages/HomePage.vue')
  },
  {
    name: 'loginPage',
    path:'/login',
    component: () => import('pages/LoginPage.vue')
  },
  {
    name:'adoptedPets',
    path:'/adopted-pets',
    component: () => import('src/pages/AdoptedPetsPage.vue')
  },
  {
    name: 'addNewPet',
    path:'/add-new-pet',
    component: () => import('src/pages/AddNewPetPage.vue')
  },
  {
    name: 'VolunteerRegister',
    path:'/volunteer-register',
    component: () => import('src/pages/VolunteerRegisterPage.vue')
  },
  {
    path: '/new-volunteer/:username',
    name: 'newVolunteer',
    component: () => import('src/pages/NewVolunteerPage.vue'),
    props: true
  },


{
  name: 'ViewVolunteers',
  path: '/view-volunteers',
  component: () => import('src/pages/ViewVolunteersPage.vue')
},

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  },

]

export default routes
