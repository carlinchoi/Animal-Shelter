const routes = [
  {
    name: "homePage",
    path: "/",
    component: () => import("pages/HomePage.vue"),
  },
  {
    name: "loginPage",
    path: "/login",
    component: () => import("pages/LoginPage.vue"),
  },
  {
    name: "adoptedPets",
    path: "/adopted-pets",
    component: () => import("src/pages/AdoptedPetsPage.vue"),
  },
  {
    name: "addNewPet",
    path: "/add-new-pet",
    component: () => import("src/pages/AddNewPetPage.vue"),
  },
  {
    name: "VolunteerRegister",
    path: "/volunteer-register",
    component: () => import("src/pages/VolunteerRegisterPage.vue"),
  },
  {
    path: "/new-volunteer/:username",
    name: "newVolunteer",
    component: () => import("src/pages/NewVolunteerPage.vue"),
    props: true,
  },
  {
    name: "ApproveVolunteers",
    path: "/approve-volunteers",
    component: () => import("src/pages/ApproveVolunteersPage.vue"),
  },
  {
    name: "ViewVolunteers",
    path: "/view-volunteers",
    component: () => import("src/pages/ViewVolunteersPage.vue"),
  },
  {
    name: "RegisterNewAccount",
    path: "/register-account",
    component: () => import("src/pages/RegisterNewAccountPage.vue"),
  },
  {
    name: "faqPage",
    path: "/frequently-asked-questions",
    component: () => import("src/pages/faqPage.vue"),
  },
  {
    name: "contactPage",
    path: "/contact-us",
    component: () => import("src/pages/contactPage.vue"),
  },
  {
    path: "/:catchAll(.*)*",
    component: () => import("pages/ErrorNotFound.vue"),
  },

];

export default routes;
