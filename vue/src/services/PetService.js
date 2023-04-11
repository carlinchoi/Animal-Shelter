import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    findAllPets() {
        return http.get('/pet/all')
    },

    getPetById(petId) {
        return http.get(`/pet/${petId}`)
    }
}