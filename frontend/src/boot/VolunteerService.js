
import axios from 'axios';

const http = axios.create({
    baseURL: "ec2-18-144-64-45.us-west-1.compute.amazonaws.com"
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
