describe('TitleBar', () => {
  beforeEach(() => {
    cy.visit('http://localhost:3000');
  });

  it('should have a title', () => {
    cy.get('h1').should('contain', 'Hit Parade');
  });

  it('should have a select populated with genres', () => {
    cy.get('select').should('have.length.greaterThan', 0);
  });
});
