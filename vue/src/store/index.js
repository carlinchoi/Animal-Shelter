import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    // petInfo: [{ 
    //   petId: '',
    //   petName: '',
    //   petPhoto: '',
    //   adopted:'',
    //   species:'',
    //   gender:'',
    //   breed:'',
    //   age:'',
    //   description:''
    // }],

    pets:[],
    volunteers:[],
    pendingVolunteers:[],
    activePet: {
      petId: null,
      petName: '',
      species: '',
      gender: '',
      breed: '',
      age: '',
      description: '',
      isAdopted: '',
      petPhoto: ''
    },
    adoptedPets:[],
    petPhotos:[]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    SET_PET_INFO(state, petData) {
      state.pets = petData;
    },
    SET_VOLANTEER_INFO(state,volunteerData){
      state.volunteers = volunteerData;
    },
    SET_ACTIVE_PET(state, data) {
      state.activePet = data;
    },
    SET_PENDING_VOLANTEER_INFO(state,volunteerData){
      state.pendingVolunteers = volunteerData;
    },
    UPDATE_VOLANTEER_ROLE(state,data){
      state.volunteers[data.index].role = data.role;
    },
    SET_ADOPTIONS_INFO(state, adoptionData) {
      state.adoptedPets = adoptionData;
    },
    SET_PET_PHOTOS(state, petPhotos) {
      state.petPhotos = petPhotos;
    }
  }
})
