<template>
    <div class="search-container container-bg">
      <input type="text" v-model="searchTerm" class="placeholder-animate">
      <label class="floating-placeholder" for="search-input">Search By First or Last Name</label>
      <table class='volunteer-table'>
      <thead>
        <tr class="active-row">
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


<style scoped>
.volunteer-table {
  width: 100%;
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 1em;
  font-family: sans-serif;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.15);
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
}

.volunteer-table thead tr {
  background-color:#62a18f;
  color: #fff;
  font-weight: bold;
  padding: 12px 15px;
  text-align: left;
  font-weight: bold;
}
.volunteer-table th,
.volunteer-table td {
  padding: 12px 15px;

}

.volunteer-table tbody td {
  padding: 12px 15px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
.volunteer-table tbody tr {
  border-bottom: 1px solid #dddddd;
}
.volunteer-table tbody tr.active-row {
  font-weight: bold;
  color: #62a18f;
}
.volunteer-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.volunteer-table tbody tr:last-of-type {
  border-bottom: 2px solid #62a18f;
}

.volunteer-table tbody tr:hover {
  background-color: #f5f5f5;
}
input {
  padding: 0.5rem;
  border: none;
  padding: 10px;
  border-radius: 10px;
 appearance: none;
 width: 50px;
}
.placeholder-animate::-webkit-input-placeholder {
  transition: all 0.3s ease-out;
  opacity: 0.5;
  transform: translateY(0px);
}
.placeholder-animate:focus + .floating-placeholder,
.placeholder-animate.valid + .floating-placeholder{
    font-size: 12px;
    top: -10px;
    left: 10px;
    color: #62a18f;
}
.search-container {
  position: relative;
}
.floating-placeholder {
  position: absolute;
  top: 12px;
  left: 20px;
  font-size: 16px;
  font-weight: bold;
  color: #ccc;
  transition: all 0.2s ease-out;
  pointer-events: none;
}
.placeholder-animate {
    width: 100%;
    border: none;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border-radius: 5px;
    font-size: 16px;
  }
  .placeholder-animate:not(:focus) {
  border-bottom: 1px solid #62a18f;
}
.background {
  background-image: url("../assets/background2.png");
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
}
.container-bg {
  background-color: #fff;
}
</style>