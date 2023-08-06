const Country = ({ country, onFavouriteToggle }) => {

  if (!country) {
    return null
  }

  const handleClick = () => {
    onFavouriteToggle(country.cca3)
  }

  const favouriteBtnText = country.isFavourite ? 'Remove from favourites' : 'Add to favourites'

  return (
    <>
      <h3>Name: {country.name.official}</h3>
      <img src={country.flags.png} alt={`Flag of ${country.name.official}`}></img>
      <button onClick={handleClick}>{favouriteBtnText}</button>
    </>
  )
}

export default Country