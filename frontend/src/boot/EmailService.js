import axios from 'axios';

const http = axios.create({
    baseURL: "http://18.144.64.45"
});

export default {

    sendEmail(email) {
        return http.post('/sendMail', email)
    }
}
