import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});
export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  }
//TODO: create .post with updated password of volunteer -- /change-password
}
