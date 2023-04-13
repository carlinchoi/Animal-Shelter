import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import VolunteerRegister from '../views/VolunteerRegister.vue'
import ChangePasswordPage from '../views/ChangePasswordPage.vue'
import AddPetListing from '../views/AddPetListing.vue'
import VolunteerList from '../views/VolunteerList.vue'
import VolunteerApplicationView from '../views/VolunteerApplicationView.vue'
import UpdatePetPage from '../views/UpdatePetPage.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/volunteer-register",
      name: "volunteer-register",
      component: VolunteerRegister,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/change-password",
      name:'change-password',
      component: ChangePasswordPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/add-pet-listing",
      name:'add-pet-listing',
      component: AddPetListing,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/volunteer-listing",
      name: "volunteer-listing",
      component: VolunteerList,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/volunteer-application",
      name: "volunteer-application",
      component: VolunteerApplicationView,
    },
    {
      path: "/update-pet-page",
      name: "update-pet-page",
      component: UpdatePetPage,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
