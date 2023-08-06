describe('Comment', () => {

    beforeEach(() => {
      cy.visit('http://localhost:3000')
    })
    it('Should have populated select', () => {
        const commentListItems = cy.get('#comment-list > li')
        commentListItems.should('have.length', 2)
    })

    it('should be able to add a comment', () => {
        cy.get('#name-input').type("John Jackson");
        cy.get('#comment-input').type("This is a test");      
        cy.get('#comment-form').submit();  
        const commentListItems = cy.get('#comment-list > li');
        commentListItems.should('have.length', 3);
      }); 
})