import axios from "axios";

const http = axios.create({
  baseURL: "https://d3gr9juy7lglgi.cloudfront.net",
});

export default {
  sendEmail(email) {
    return http.post("/sendMail", email);
  },
};
