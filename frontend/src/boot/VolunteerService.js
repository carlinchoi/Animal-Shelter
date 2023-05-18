import axios from "axios";

const http = axios.create({
  baseURL: "https://d3gr9juy7lglgi.cloudfront.net",
});

export default {
  findAllVolunteer() {
    return http.get("/volunteer/all");
  },
  createVolunteer(volunteerApplication) {
    return http.post("/user/pending-volunteer", volunteerApplication);
  },
  updateVolunteer(volunteerApplication) {
    return http.put("/user/pending-volunteer", volunteerApplication);
  },
  updateVolunteerStatus(volunteer) {
    return http.put("/volunteer/volunteer-pending-list", volunteer);
  },
  findAllPendingVolunteer() {
    return http.get("/volunteer/pending-volunteer");
  },
  findVolunteerToPromote() {
    return http.get("/volunteer/volunteer-to-promote");
  },
};
