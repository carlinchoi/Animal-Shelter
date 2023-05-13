
import axios from 'axios';

const http = axios.create({
    baseURL: "18.144.64.45"
});

export default {

    findAllVolunteer() {
        return http.get('/volunteer/all')
    },
    createVolunteer(volunteerApplication) {
        return http.post('/user/pending-volunteer', volunteerApplication)
    },
    updateVolunteer(volunteerApplication) {
        return http.put('/user/pending-volunteer', volunteerApplication)
    },
    updateVolunteerStatus(volunteer){
        return http.put('/volunteer/volunteer-pending-list',volunteer)
    },
    findAllPendingVolunteer() {
        return http.get('/volunteer/pending-volunteer')
    },
    findVolunteerToPromote() {
        return http.get('/volunteer/volunteer-to-promote')
    },

}
