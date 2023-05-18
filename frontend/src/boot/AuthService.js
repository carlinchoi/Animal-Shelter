import axios from "axios";

const http = axios.create({
  baseURL: "https://d3gr9juy7lglgi.cloudfront.net",
});
export default {
  login(user) {
    return http.post("/login", user);
  },

  register(user) {
    return http.post("/register", user);
  },
  //TODO: create .post with updated password of volunteer -- /change-password
};
