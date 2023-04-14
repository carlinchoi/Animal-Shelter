<template>

  <div >
    <h1>From Component</h1>

    <table class='volunteer-table'>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Role</th>
          <th>userid</th>
         
        </tr>
      </thead>
      <tbody>
        <tr v-for="volunteer in pendingVolunteers" v-bind:key="volunteer.userid">
          <td>{{ volunteer.firstName }}</td>
          <td>{{ volunteer.lastName }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phone }}</td>
  
          <td>
            <select  @change="updateStatus(volunteer, $event)" >
              <option value="ROLE_PENDINGVOLUNTEER">pending</option>
              <option value="ROLE_APPROVED">approved</option>
              <option value="ROLE_DECLINED">delined</option>
            </select>     
          </td>
          <td>{{ volunteer.userId }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import volunteerService from '../services/VolunteerService.js';
export default {
  name: "view-pending-volunteers",
  methods: {
    retrieveVolunteers(){
      alert("debug retrieveVolunteers")
      volunteerService.findAllPendingVolunteer().then((response) => {
        console.log("findAllPendingVolunteer"+response.data)
        this.$store.commit("SET_PENDING_VOLANTEER_INFO", response.data);
      });
    },
    updateStatus(volunteer,event){ 
      console.log(event.target.value+volunteer);
     
        console.log(volunteer);
        volunteerService.updateVolunteerStatus(volunteer).then((response)=>{
         if (response.status == 200) {
          this.$store.commit("SET_VOLANTEER_INFO", response.data);
          this.$router.push( {name:'volunteer-pending-list'});
          }  }) 

       volunteerService.findAllVolunteer().then((response) => {
        this.$store.commit("SET_PENDING_VOLANTEER_INFO", response.data);
      });
    },
  computed: {
    pendingVolunteers(){
      return this.$store.state.pendingVolunteers
    }
  },
  created(){
    this.retrieveVolunteers();
   
  },
}}
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