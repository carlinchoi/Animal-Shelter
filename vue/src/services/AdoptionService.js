import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createAdoption(petId, parentName, parentEmail) {
        return http.post('/adoption-form', petId, parentName, parentEmail)
      },
    
}