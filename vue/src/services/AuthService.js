import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }
//TODO: create .post with updated password of volunteer -- /change-password
}
