import axios from 'axios';

export default {

    findAllPets() {
        return axios.get('/pet/all')
    },

    getPetById(petId) {
        return axios.get(`/pet/${petId}`)
    }
}