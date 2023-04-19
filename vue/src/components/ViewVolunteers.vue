<template>
<body class="pupkit-bg">
  <h1> View Volunteers </h1>
  <div class="search-container container-bg background">
  
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
h1 {
  border: 1px solid black;
  background: #62a18f;
  padding: 20px;
  border-radius: 50%;
  color:white;
  text-align: center;
  
}
.table-container {
  max-height: 400px;
  overflow: auto;
}
.volunteer-table {
  font-family: Montserrat, sans-serif;
  width: 100%;
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 1em;
  font-family: sans-serif;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, .10);
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;

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
  color: #5c5470;
  font-weight: bold;
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
  border: 2px solid black;
  padding: 10px;
  border-radius: 10px;
}
.placeholder-animate::-webkit-input-placeholder {
  transition: all 0.3s ease-out;
  opacity: 0.5;
  transform: translateY(0px);
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
.background {
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
  z-index: 10;
}
.container-bg {
  background-color: #fff;
}
label {
  color: rgb(206, 191, 224);
}
.background {
  background-image: url('../assets/pupkit.png');
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
  z-index: 10;
}
body {
  background-image: url('../assets/pupkit.png');
  background-size: cover;
}
</style>