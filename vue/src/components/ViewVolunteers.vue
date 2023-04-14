<template>
  <div>
    <div class="search-container">
      <input type="text" v-model="searchTerm" placeholder="Search By Name">
      <table class='volunteer-table'>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Role</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="volunteer in filteredVolunteers" :key="volunteer.email">
          <td>{{ volunteer.firstName }}</td>
          <td>{{ volunteer.lastName }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phone }}</td>
          <td>{{ volunteer.role }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  </div>
</template>

<script>
import VolunteerService from '../services/VolunteerService.js';
export default {
  name: "view-volunteers",
  data() {
    return {
      searchTerm: '',
      selectedRole: null,

    }
  },
  methods: {
    retrieveVolunteers(){
      VolunteerService.findAllVolunteer().then((response) => {
        this.$store.commit("SET_VOLANTEER_INFO", response.data);
      });
    }
  },
  computed: {
  volunteers() {
    return this.$store.state.volunteers;
  },
  filteredVolunteers() {
    let filtered = this.volunteers;
    if (this.searchTerm) {
      filtered= filtered.filter (volunteer =>
       volunteer.firstName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
          volunteer.lastName.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }
    if (this.selectedRole) {
      filtered= filtered.filter(volunteer =>
      volunteer.role === this.selectedRole
      );
    }
    return filtered;
  }
  },
  created(){
    this.retrieveVolunteers();
   
  },
}
</script>


<style>
.volunteer-table {
  width: 100%;
  border-collapse: collapse;
  margin: 0 auto;
  font-size: 1em;
  font-family: sans-serif;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
}

.volunteer-table thead th {
  background-color: #192a56;
  color: #fff;
  font-weight: bold;
  padding: 12px 15px;
  text-align: left;
}

.volunteer-table tbody td {
  padding: 12px 15px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.volunteer-table tbody tr:last-of-type td {
  border-bottom: none;
}

.volunteer-table tbody tr:hover {
  background-color: #f5f5f5;
}
</style>