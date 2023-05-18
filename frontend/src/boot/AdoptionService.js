import axios from "axios";

const http = axios.create({
  baseURL: "https://d3gr9juy7lglgi.cloudfront.net",
});

export default {
  createAdoption(adoption) {
    return http.post("/adoption-form", adoption);
  },

  findAllAdoptions() {
    return http.get("/view-adoptions");
  },
};
