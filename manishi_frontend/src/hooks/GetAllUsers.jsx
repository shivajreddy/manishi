import axios from 'axios'
import { useEffect, useState } from 'react'

// returns the list of all users
function FetchAllUsers () {
	
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

export default FetchAllUsers


// axios.get(
//   usersUrl,
//   {
//     auth: {
//       username: 'user',
//       password: 'pass',
//     },
//   },
// ).then(res => console.log('GET: /users', res))

// axios.get(
//   demoUrl,
//   {
//     auth: {
//       username: 'user',
//       password: 'pass',
//     },
//   },
// ).then(res => console.log('GET: /demo', res))

// axios.post(
// 	demoUrl,
// 	{
// 		'data-key-1': 'data-val-1',
// 		'data-key-2': 'data-val-2',
// 	},
// 	{
// 		auth: {
// 			username: 'user',
// 			password: 'pass',
// 		},
// 	},
// ).then(res => console.log('POST: /demo', res))

// axios.post(
// 	baseUrl + '/sign-up',
// 	{
// 		'username': 'shiva',
// 		'password': 'pass',
// 	},
// ).then(res => console.log('post to /users with data', res))
