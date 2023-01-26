import React, { useState } from 'react'
import { Box, Button, Card } from '@mui/material'

const Test = () => {
  
  // controller inputs
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [rePassword, setRePassword] = useState('')
  
  function handleSubmit(event) {
    event.preventDefault();
    console.log("form is submitted with values")
    console.log("username=", event.target.username.value)
    console.log("password=", event.target.password.value)
    console.log("re-password=", event.target.repassword.value)
    
    if (password === rePassword){
    
    }
    
  }
  
  return (
    <div>
      
      <Box padding="10px">
        <Card sx={{ maxWidth: 500, margin: 'auto' }}>
          <form onSubmit={handleSubmit}>
            <div>
              <label htmlFor="username">Username:</label>
              <input type="text" id="username" value={username}
                     onChange={event => setUsername(event.target.value)}/>
            </div>
            <div>
              <label htmlFor="password">Password:</label>
              <input type="password" id="password" value={password}
                     onChange={event => setPassword(event.target.value)}/>
            </div>
            <div>
              <label htmlFor="repassword">Confirm:</label>
              <input type="password" id="repassword" value={rePassword}
                     onChange={event => setRePassword(event.target.value)}/>
            </div>
            <Button type="submit" variant="outlined" >submit</Button>
          </form>
        </Card>
      
      </Box>
    
    </div>
  )
}


export default Test
