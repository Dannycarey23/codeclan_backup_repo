import styled from 'styled-components';

const Quote = ({by, source, children}) => {
    return (
        <Figure>
            <QuoteContent>{children}</QuoteContent>
            <figcaption>
                    <Author>
                        <SourceLink href={source}>
                            {by}
                        </SourceLink>
                    </Author>
            </figcaption>
        </Figure>
    );
};

const Figure = styled.figure`
  text-align: center;
`

const QuoteContent = styled.blockquote`
  margin: 0 auto;
  background: hsl(0deg 0% 90%);
  padding: 16px 20px;
  border-radius: 8px;
  font-style: italic;
  width: 250px;

  &::before {
    content: '"';
  }

  &::after {
    content: '"';
  }
`;

const Author = styled.cite`
    display: block;
    margin-top: 8px;
`;

const SourceLink = styled.a`
  text-decoration: none;
  color: hsl(0deg 0% 35%);

  &:hover {
    text-decoration: underline;
  }

  &::before {
    content: '-';
  }
`;

export default Quote;