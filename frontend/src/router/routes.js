
const routes = [
  {
    name: 'homePage',
    path: '/',
    component: () => import('pages/HomePage.vue')
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
    name: 'newVolunteer',
    path: '/new-volunteer',
    component: () => import('src/pages/NewVolunteerPage.vue')
},
{
  name: 'CreateAccount',
  path:'/create-account',
  component:() => import ('src/pages/CreateAccountPage.vue')
},
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  },

]

export default routes
