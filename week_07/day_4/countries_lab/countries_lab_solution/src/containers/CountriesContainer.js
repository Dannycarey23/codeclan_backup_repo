import { useState, useEffect} from 'react'
import CountrySelector from '../components/CountrySelector'
import Country from '../components/Country'
import FavouriteCountries from '../components/FavouriteCountries'

const CountriesContainer = () => {

  const [countries, setCountries] = useState([])
  const [selectedCountryCCA3Code, setSelectedCountryCCA3Code] = useState('')

  useEffect(() => {
    getCountries()
  }, [])

  const getCountries = () => {
    fetch("https://restcountries.com/v3.1/all")
      .then(res => res.json())
      .then(countriesData => setCountries(countriesData))
  }

  const handleCountrySelected = cca3 => {
    setSelectedCountryCCA3Code(cca3)
  }

  const handleFavouriteToggle = (cca3) => {
    const updatedCountries = countries.map((country) => {
      return country.cca3 === cca3 
        ? {...country, isFavourite: !country.isFavourite}
        : country
    })
    setCountries(updatedCountries)
  }

  const totalPopulation = countries.reduce((total, country) => {
    return total + country.population
  }, 0)

  const selectedCountry = countries.find(country => country.cca3 === selectedCountryCCA3Code)

  return (
    <>
      <h2>Countries Container</h2>
      <p>Total population: {totalPopulation}</p>
      <CountrySelector countries={countries} onCountrySelected={handleCountrySelected} />
      <Country country={selectedCountry} onFavouriteToggle={handleFavouriteToggle} />
      <FavouriteCountries countries={countries} onCountrySelected={handleCountrySelected} />
    </>
  )
}

export default CountriesContainer
