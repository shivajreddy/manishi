import React, { useEffect, useState } from 'react'
import '../styles/Box2.css'

const MainBox = (props) => {
  
  return (
    <div className="main-box">
      <div className="main-sub-box">
        <h1 className="title">Manishi</h1>
        {props.children}
      </div>
    </div>
  )
}

export default MainBox
