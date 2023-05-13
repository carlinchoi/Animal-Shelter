import axios from 'axios';

const http = axios.create({
    baseURL: "ec2-18-144-64-45.us-west-1.compute.amazonaws.com"
});

export default {

    createAdoption(adoption) {
        return http.post('/adoption-form', adoption)
      },

    findAllAdoptions() {
        return http.get('/view-adoptions')
    }

}
