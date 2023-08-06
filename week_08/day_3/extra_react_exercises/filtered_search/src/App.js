import './App.css';
import React, {useEffect, useState} from 'react';
import styled from 'styled-components';

function App() {

  const [countries, setCountries] = useState([]);
  const [filteredList, setFilteredList] = useState([]);

  useEffect( () => {
    fetchCountries();
  }, []);

  const fetchCountries = () => {
    fetch("https://restcountries.com/v3.1/all")
      .then( res => res.json() )
      .then( (data) => {

        const countryNames = data.map((country) => {
          return country.name.common;
        })

        setFilteredList(countryNames);
        setCountries(countryNames);
      })
  }


  const handleSearch = (event) => {

    const filteredValues = countries.filter((country) =>  {
        return country.toLowerCase().includes(event.target.value.toLowerCase());
      }
    );

    setFilteredList(filteredValues);
  };

  // Create an array of items for displaying
  const filteredCountries = filteredList.map( (country, index) => {
    return <Country key={index}>{country}</Country>
  });

  return (
    <FilteredSearch>
      <div>
        Search: <SearchInput type="text" onChange={handleSearch} />
      </div>
      <CountryList>
        {filteredCountries}
      </CountryList>
  </FilteredSearch>
  );
}

const FilteredSearch = styled.div`
  width: 300px;
  margin: 0 auto;
  font-size: 1.5rem;
`;

const SearchInput = styled.input`
  font-size: inherit;
  border-radius: 5px;
  margin-top: 10px;
`;

const CountryList = styled.ul`
  padding-left: 0;
`;

const Country = styled.li`
  list-style: none;
`;

export default App;
