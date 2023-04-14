import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createAdoption(adoption) {
        return http.post('/adoption-form', adoption)
      },
    
}