import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"
// });

export default {

    findAllPets() {
        return axios.get('/pet/all')
    },

    getPetById(petId) {
        return axios.get(`/pet/${petId}`)
    }
}