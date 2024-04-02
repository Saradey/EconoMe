# Readme

This project is for my personal use, aimed at tracking financial expenses and comparing prices in
different stores for statistical purposes. I developed this application for myself to monitor my
financial outgoings. It's not intended as a commercial business solution but rather to demonstrate
my Android platform development skills.

Regarding the architecture:

- mvvm/Coroutine Flow
- di/dagger dependencies
- gradle multimodal project (split feature: api/impl)
- single activity
- multibackstack fragments navigation
- cicerone (navigation)

Here is the technology stack used:

- jetpack compose with fragments - ui (with costume theme)
- coroutines - async
- Room - database

Implementations:

- deeplink
- notification
- WorkManager
- service
- unit tests/ui tests/integration tests
- widget on desktop launcher
- Ci github actions
    - detekt check
    - lint check
    - run unit tests