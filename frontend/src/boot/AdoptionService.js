import axios from 'axios';

const http = axios.create({
  baseURL: "http://18.144.64.45:9000"
});

export default {

    createAdoption(adoption) {
        return http.post('/adoption-form', adoption)
      },

    findAllAdoptions() {
        return http.get('/view-adoptions')
    }

}
