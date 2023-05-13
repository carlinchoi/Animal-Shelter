import axios from 'axios';

const http = axios.create({
    baseURL: "ec2-18-144-64-45.us-west-1.compute.amazonaws.com"
});

export default {

    findAllPets() {
        return http.get('/pet/all')
    },

    getPetById(petId) {
        return http.get(`/pet/${petId}`)
    },

    createPet(pet) {
        return http.post('/pet/all', pet)
    },

    updatePet(petId, pet) {
        return http.put(`/pet/${petId}`, pet)
    },

    findAdoptedPets() {
        return http.get('/pet/all-adopted')
    },

    findAllPhotos(petId) {
        return http.get(`/pet/pet-photos/${petId}`)
    }
}
