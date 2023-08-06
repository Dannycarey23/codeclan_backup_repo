const OptionItem = ({index, country}) => {
    return <option value={index}>{country.name.common}</option>
}

export default OptionItem;