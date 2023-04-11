import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getUserById(userId) {
        return http.get(`/user/${userId}`)
    }

}