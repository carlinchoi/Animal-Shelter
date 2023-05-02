
const routes = [
  {
    name: 'homePage',
    path: '/',
    component: () => import('pages/HomePage.vue')
  },
  {
    name:'adoptedPets',
    path:'/adopted-pets',
    component: () => import('pages/AdoptedPets.vue')
  },
  {
    name: 'addNewPet',
    path:'/add-new-pet',
    component: () => import('pages/AddNewPet.vue')
  },
  {
    name: 'newVolunteer',
    path: '/new-volunteer',
    component: () => import('pages/newVolunteer.vue')
},
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  },
]

export default routes
