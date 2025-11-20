## [Release](https://git.dev.box.net/AppServices/graphql/compare/0.0.66...0.0.67) (2025-11-20)

### Schema diff **- has breaking changes**

<details>
    <summary>Click to expand</summary>

Detected the following changes (10) between schemas:  
  
✖  Enum value GENERAL was removed from enum GenerateDocumentOutcomeSubtype  
⚠  Input field baseAgent of type String was added to input object type AiSessionDataInput  
⚠  Input field source of type String was added to input object type AiSessionDataInput  
⚠  Enum value DEFAULT was added to enum GenerateDocumentOutcomeSubtype  
✔  Type AiStudioAgentDuplicatedPayload was added  
✔  Field shuttleBCAccessEnabled was added to object type ContentAndSharingConfigurations  
✔  Type DuplicateAiStudioAgentError was added  
✔  Type DuplicateAiStudioAgentInput was added  
✔  Field GenerateDocumentOutcome.outcomeSubtype description changed from Subtype of the outcome, value is always GENERAL to Subtype of the outcome, value is always DEFAULT  
✔  Field duplicateAiStudioAgent was added to object type Mutation  

Detected 1 breaking change
</details>

### Bug Fixes

* changes to schema and e2e test [BIQ-7682] ([#1815](https://git.dev.box.net/AppServices/graphql/issues/1815)) ([6483f62](https://git.dev.box.net/AppServices/graphql/commits/6483f620ee782a24a30b17f5cffd9985a80d8990))
* remove high cardinality fields from resolver metrics [APPSERV-3540] ([#1827](https://git.dev.box.net/AppServices/graphql/issues/1827)) ([847c3a5](https://git.dev.box.net/AppServices/graphql/commits/847c3a5ccebd7b27fd06cfb9891e20761f63eb4f))


### Features

* Add new BC Access Enabled setting in GraphQL BFF [CF-9810] ([#1729](https://git.dev.box.net/AppServices/graphql/issues/1729)) ([3cddaf0](https://git.dev.box.net/AppServices/graphql/commits/3cddaf0841dad9026202c6d8b83104eb8f0724b5))
* added duplicateAiStudioAgent [AISTUDIO-3323] ([#1818](https://git.dev.box.net/AppServices/graphql/issues/1818)) ([a58c589](https://git.dev.box.net/AppServices/graphql/commits/a58c5895fc7300975e1b9e28c350db8ca6ee83db))
* query forms api to get form by id [BWP-10278] ([#1795](https://git.dev.box.net/AppServices/graphql/issues/1795)) ([83ccc7d](https://git.dev.box.net/AppServices/graphql/commits/83ccc7d22dbf75b9534eb33854c3d9d2d1226702))
* use new subtype for Generate Document ([#1824](https://git.dev.box.net/AppServices/graphql/issues/1824)) ([06b7347](https://git.dev.box.net/AppServices/graphql/commits/06b7347b0c486725ba8ede017c06dd4c1d7bd8f1))
* **workflow:** Add e2e tests for workflow itemV2 queries [BWP-11128] ([#1803](https://git.dev.box.net/AppServices/graphql/issues/1803)) ([cec246f](https://git.dev.box.net/AppServices/graphql/commits/cec246fcc20f9dcc46e4fec0976828709883f394))


