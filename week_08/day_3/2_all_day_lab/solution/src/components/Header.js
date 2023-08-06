import React, { useState } from 'react';
import { Link } from "react-router-dom";
import styled from 'styled-components';

const StyledHeader = styled.header`
  background-color: black;
  color: white;
  display: flex;
  justify-content: space-between;
`

const HeaderGroup = styled.hgroup `
  display: flex;
flex-direction: column;
margin: 0;
padding-left: 30px;
`

const Header = ( { user } ) => {


  return (
    <StyledHeader>
        <HeaderGroup>
          <h1>DJ Sports</h1>
          <h4>Prince of Trainers</h4>
        </HeaderGroup>

      <nav>
        <ul>
          <li><Link to="/">View Stock</Link></li>
        </ul>


      </nav>
      <div id="user-info">
        <h3>Welcome back { user.name }</h3>
        <h4>You have { user.basket.length } items in your basket</h4>
        <Link to="/basket">Go to Basket</Link>

      </div>
    </StyledHeader>
  );
};

export default Header;
