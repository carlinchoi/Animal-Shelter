<template>
<body>
  <div>
    <h1> View Volunteers </h1>
  <div class="search-container">
    <input type="text" v-model="searchTerm" class="placeholder-animate" />
    <label class="floating-placeholder" for="search-input"
      >Search by First or Last Name</label>
    <div class="table-container">  
    <table class="volunteer-table">
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
  </div>
  </div>
  </body>
</template>

<script>
import VolunteerService from "../services/VolunteerService.js";
export default {
  name: "view-volunteers",
  data() {
    return {
      searchTerm: "",
      selectedRole: null,
    };
  },
  methods: {
    retrieveVolunteers() {
      VolunteerService.findAllVolunteer().then((response) => {
        this.$store.commit("SET_VOLANTEER_INFO", response.data);
      });
    },
  },
  computed: {
    volunteers() {
      return this.$store.state.volunteers;
    },
    filteredVolunteers() {
      let filtered = this.volunteers;
      if (this.searchTerm) {
        filtered = filtered.filter(
          (volunteer) =>
            volunteer.firstName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.lastName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase())
        );
      }
      if (this.selectedRole) {
        filtered = filtered.filter(
          (volunteer) => volunteer.role === this.selectedRole
        );
      }
      return filtered;
    },
  },
  created() {
    this.retrieveVolunteers();
  },
};
</script>


<style scoped>
body {
  background-image: url('../assets/pupkit.png');
  height: 150%;
  width: 100%;
}
h1 {
  color: #62a18f;
  font-size: 4rem;
  font-family: Montserrat, sans-serif;
  font-weight: bold;
  text-align: center;
  margin-top: 2rem;
}
.table-container {
  max-height: 490px;
  overflow: auto;
  width: 100%;
}
.volunteer-table {
  font-family: Montserrat, sans-serif;
  width: 100%;
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 1em;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.15);
  border-radius: 5px 5px 0 0;
  background-color: rgba(255, 255, 255, 0.6);
}
.volunteer-table thead {
position: sticky;
}
.volunteer-table thead th {
  color: white;
}
.volunteer-table thead tr {
  background-color: #62a18f;
  color: #fff;
  font-weight: bold;
  padding: 12px 15px;
  text-align: left;
  font-weight: bold;
}
.volunteer-table th,
.volunteer-table td {
  padding: 12px 15px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  color: black;
  font-weight: bold;
}
.volunteer-table tbody {
  height:50vh;
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
.volunteer-table tbody tr:last-of-type {
  border-bottom: 2px solid #62a18f;
}

.volunteer-table tbody tr:hover {
  background-color: #f5f5f5;
  color: black;
}
input {
  padding: 0.5rem;
  border: 2px solid black;
  padding: 10px;
  border-radius: 10px;
}
.placeholder-animate::-webkit-input-placeholder {
  transition: all 0.3s ease-out;
  opacity: 0.5;
  transform: translateY(0px);
}
.placeholder-animate:focus + .floating-placeholder,
.placeholder-animate.valid + .floating-placeholder {
   font-size: 25px;
  top: -20px;
  left: 10px;
  color: black;
  font-weight: bold;
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
  border: 2px solid rgb(0, 0, 0);
  
}
label {
  color: rgb(206, 191, 224);
}
.background {
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: 33%;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
  z-index: 10;
}
.select{
padding: 8px 12px;
color: black;
background-color: #eeeeee;
border: 1px solid #dddddd;
cursor: pointer;
border-radius: 5px;
}
.select:focus,
.select:hover {
  outline: none;
  border: 1px solid #bbbbbb;
}
.select option {
  background: #ffffff;
  color:black;
}
</style>