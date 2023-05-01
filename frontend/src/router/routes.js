
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

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
