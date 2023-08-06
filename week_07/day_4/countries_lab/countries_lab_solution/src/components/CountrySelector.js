const CountrySelector = ({ countries, onCountrySelected }) => {

    const handleChange = event => {
        onCountrySelected(event.target.value)
    }

  return (
    <select defaultValue="" onChange = { handleChange } >
        <option value = "" disabled > Choose a country </option> {
            countries.map(country => {
                return ( <
                    option key = { country.cca3 }
                    value = { country.cca3 } > { country.name.official } </option>
                )
            })
        }
    </select>
  )
}

export default CountrySelector