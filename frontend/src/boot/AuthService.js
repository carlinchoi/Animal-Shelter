import api from './axios';

export default {

  login(user) {
    return api.post('/login', user)
  },

  register(user) {
    return api.post('/register', user)
  }
//TODO: create .post with updated password of volunteer -- /change-password
}
