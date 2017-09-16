Principle - Verify that a known, fixed input produces a known, fixed output

Rules:

1. dont have input/output dependent on model static constants/random numbers/enviorment dates
2. use TDD
3. make your test fail first- then write code to make it pass
4. one test - one assert GOOD
5. individual - test methods should be able to run in any order
6. don't use NON-CONTSTANT Static fields
7. Tests don't share instance data, so you can init outside the test (code)

