import { store } from "quasar/wrappers";
import { createStore } from "vuex";
import axios from "axios";

const currentToken = localStorage.getItem("token");
const currentUser = JSON.parse(localStorage.getItem("user"));

if (currentToken != null) {
  axios.defaults.headers.common["Authorization"] = `Bearer ${currentToken}`;
}

export default store(function () {
  const Store = createStore({
    state: {
      token: currentToken || "",
      user: currentUser || {},
      pets: [],
      volunteers: [],
      pendingVolunteers: [],
      activePet: {
        petId: null,
        petName: "",
        species: "",
        gender: "",
        breed: "",
        age: "",
        description: "",
        isAdopted: "",
        petPhoto: "",
      },
      adoptedPets: [],
      petPhotos: [],
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem("token", token);
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem("user", JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        state.token = "";
        state.user = {
          authorities: [
            {
              name: "ROLE_USER",
            },
          ],
        };
        axios.defaults.headers.common = {};
      },
      SET_PET_INFO(state, petData) {
        state.pets = petData;
      },
      SET_VOLUNTEER_INFO(state, volunteerData) {
        state.volunteers = volunteerData;
      },
      SET_ACTIVE_PET(state, data) {
        state.activePet = data;
      },
      SET_PENDING_VOLANTEER_INFO(state, volunteerData) {
        state.pendingVolunteers = volunteerData;
      },
      UPDATE_VOLUNTEER_ROLE(state, data) {
        state.volunteers[data.index].role = data.role;
      },
      SET_ADOPTIONS_INFO(state, adoptionData) {
        state.adoptedPets = adoptionData;
      },
      SET_PET_PHOTOS(state, petPhotos) {
        state.petPhotos = petPhotos;
      },

    },
    actions: {
      async fetchData({ commit }) {
        try {
          const response = await axios.get("/api/data");
          const { data } = response;
          commit("SET_DATA", data);
        } catch (error) {
          console.log(error);
        }
      },
    },
    modules: {},
    strict: process.env.DEBUGGING,
  });

  return Store;
});
