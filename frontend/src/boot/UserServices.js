import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getUserById(userId) {
        return http.get(`/user/${userId}`)
    },
    updateRoleById(userId, user) {
        return http.put(`/user/${userId}`, user);
    },
    updateRoleByUsername(username, user) {
        return http.put(`/user/${username}`, user);
    },
    updateUserByUsername(username, user) {
        return http.put(`/user/${username}`, user);
    },
    deleteByUsername(username, user) {
        return http.delete(`/user/${username}`, user);
    },
    updateUserPassword(user) {
        return http.put('/update-password', user);
    }


}
