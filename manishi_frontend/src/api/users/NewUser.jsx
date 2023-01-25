import { useEffect, useState } from 'react'
import axios from 'axios'

function CreateNewUser(user) {
	
	const baseUrl = 'http://localhost:8080'
	const demoUrl = baseUrl + '/demo'
	const usersUrl = baseUrl + '/users'
	
	// const [data, setData] = useState(null)
	// let users = null
	const [users, setUsers] = useState(null)
	
	useEffect(()=>{
		
		axios.get(
			usersUrl,
			{
				auth: {
					username: 'user',
					password: 'pass',
				},
			},
		).then(res =>setUsers(res.data))
		
	}, [usersUrl])
	
	return  users
}
