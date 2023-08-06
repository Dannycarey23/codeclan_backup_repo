const LaunchSelector = ({launchIncrease, launchDecrease}) => {

  return (
    <>
      <button onClick={launchDecrease}>Previous Launch</button>
      <button onClick={launchIncrease}>Next Launch</button>
    </>
  )

}

export default LaunchSelector;