---
name: Smart Crop Care
colors:
  surface: '#f8f9ff'
  surface-dim: '#d0dbed'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eff4ff'
  surface-container: '#e6eeff'
  surface-container-high: '#dee9fc'
  surface-container-highest: '#d9e3f6'
  on-surface: '#121c2a'
  on-surface-variant: '#41493e'
  inverse-surface: '#27313f'
  inverse-on-surface: '#eaf1ff'
  outline: '#717a6d'
  outline-variant: '#c0c9bb'
  surface-tint: '#2a6b2c'
  primary: '#00450d'
  on-primary: '#ffffff'
  primary-container: '#1b5e20'
  on-primary-container: '#90d689'
  inverse-primary: '#91d78a'
  secondary: '#1b6d24'
  on-secondary: '#ffffff'
  secondary-container: '#a0f399'
  on-secondary-container: '#217128'
  tertiary: '#5c2f00'
  on-tertiary: '#ffffff'
  tertiary-container: '#7e4200'
  on-tertiary-container: '#ffb579'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#acf4a4'
  primary-fixed-dim: '#91d78a'
  on-primary-fixed: '#002203'
  on-primary-fixed-variant: '#0c5216'
  secondary-fixed: '#a3f69c'
  secondary-fixed-dim: '#88d982'
  on-secondary-fixed: '#002204'
  on-secondary-fixed-variant: '#005312'
  tertiary-fixed: '#ffdcc3'
  tertiary-fixed-dim: '#ffb77d'
  on-tertiary-fixed: '#2f1500'
  on-tertiary-fixed-variant: '#6e3900'
  background: '#f8f9ff'
  on-background: '#121c2a'
  surface-variant: '#d9e3f6'
typography:
  display-lg:
    fontFamily: Roboto Flex
    fontSize: 40px
    fontWeight: '700'
    lineHeight: 48px
    letterSpacing: -0.02em
  display-lg-mobile:
    fontFamily: Roboto Flex
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-lg:
    fontFamily: Roboto Flex
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 36px
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Roboto Flex
    fontSize: 22px
    fontWeight: '600'
    lineHeight: 28px
  headline-sm:
    fontFamily: Roboto Flex
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
  title-lg:
    fontFamily: Roboto Flex
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 22px
  title-md:
    fontFamily: Roboto Flex
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
  body-lg:
    fontFamily: Roboto Flex
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-md:
    fontFamily: Roboto Flex
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  body-sm:
    fontFamily: Roboto Flex
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
  label-lg:
    fontFamily: Roboto Flex
    fontSize: 14px
    fontWeight: '500'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-md:
    fontFamily: Roboto Flex
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.02em
  label-sm:
    fontFamily: Roboto Flex
    fontSize: 11px
    fontWeight: '600'
    lineHeight: 14px
    letterSpacing: 0.03em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  gutter-sm: 0.75rem
  margin: 1rem
  margin-tablet: 1.5rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
---

## Brand & Style

This design system delivers a resilient, high-utility mobile interface tailored for agricultural management, field operations, and real-time crop analytics. It addresses users who frequently interact with software under direct sunlight, while wearing gloves, or amidst demanding field environments. The visual language merges Material 3 mechanical discipline with natural agricultural vitality, evoking reliability, clarity, scientific precision, and practical ease.

The aesthetic philosophy centers on modern utilitarianism: robust structural grids, deep forest greens grounding the biological focus, tactical amber accents signifying physiological crop shifts and alerts, and high-legibility typographic hierarchies. Rather than abstract decoration, visual elements prioritize fast scanning, distinct actionable regions, and instant situational awareness across crop life cycle stages.

## Colors

The color palette is built for sunlight contrast, optical comfort, and unambiguous diagnostic communication:

- **Primary (`#1B5E20`):** Grounded deep forest green. Used for authoritative primary actions, navigation headers, active navigation indicators, and primary visual anchors.
- **Secondary (`#2E7D32`):** Medium leaf green. Serves as a supporting biological accent, representing healthy physiological status, secondary confirmed states, and progressive metrics.
- **Tertiary (`#D97706`):** Warm harvest amber. Designated for vital agricultural alerts, moisture or pest thresholds, required user interventions, and pending warnings.
- **Neutral (`#1F2937`):** Dark charcoal slate. Provides high-contrast readability against pale backgrounds, eliminating the harsh eye fatigue of pure `#000000`.

### Background & Surface Hierarchy
- **Canvas Base:** `#F8FAF6` (warm off-white/cream) to reduce glare in outdoor conditions.
- **Surface Container Lowest:** `#FFFFFF` for elevated diagnostic cards and modals.
- **Surface Container High:** `#F0F4EE` for recessed input fields, progress track backdrops, and secondary grouped containers.
- **Outline & Borders:** `#D6DEC9` for accessible, crisp boundary definitions that maintain card autonomy in high ambient light.
- **Semantic Feedback:**
  - **Success:** `#1B5E20` / Container: `#E8F5E9`
  - **Warning:** `#D97706` / Container: `#FEF3C7`
  - **Critical / Error:** `#B91C1C` / Container: `#FEE2E2`
  - **Informational:** `#0369A1` / Container: `#E0F2FE`

## Typography

The type system relies on `Roboto Flex` across all roles, exploiting its parametric versatility, mechanical cadence, and legibility on mobile viewports.

- **Scale & Contrast:** Outdoor usage requires exaggerated contrast ratios. Metric readings, soil temperatures, moisture percentages, and critical stage titles use heavier weights (`600` and `700`) to guarantee comprehension through dust or screen glare.
- **Tabular Data Support:** Metric data readouts in sensor blocks should activate OpenType tabular numbers (`tnum`) to maintain structural vertical alignment across rapidly updating sensor telemetry.
- **Labels & Micro-copy:** Uppercase transformations are reserved strictly for high-priority micro-badges (`label-sm`), ensuring standard agricultural terminology remains effortless to parse.

## Layout & Spacing

The layout is built on a 4px baseline sub-grid combined with an 8px primary layout rhythm. It focuses on fluid single-column mobile setups and multi-pane responsive tablet displays:

- **Mobile Viewports (<600px):** Single-column layout with fixed outer margins of `1rem` (16px) and interior column gutters of `1rem`. Touch targets conform strictly to a 48x48px minimum envelope.
- **Tablet / Rugged Field Slates (600px - 1024px):** Dual-column layout featuring `1.5rem` margins. The left master view displays crop zones and sensor arrays; the right detail pane provides AI diagnostics, stage chronologies, and input recommendations.
- **Vertical Rhythm:** Stacked cards and monitoring widgets maintain a consistent `space-md` (16px) gap. Dense sub-elements (status metrics, telemetry points) utilize `space-xs` (4px) and `space-sm` (8px).

## Elevation & Depth

This system implements Material 3 surface container tiers enhanced with crisp, low-contrast structural outlines (`#D6DEC9`) rather than heavy blurred drop shadows. This prevents muddy rendering on mid-tier rugged mobile displays:

- **Level 0 (Base Canvas):** `#F8FAF6` flat background.
- **Level 1 (Cards, Metric Modules, List Tiles):** `#FFFFFF` surface with a 1px solid border (`#D6DEC9`) and subtle ambient elevation: `0px 1px 3px rgba(31, 41, 55, 0.06)`.
- **Level 2 (Active Cards, Expandable Panels, Filter Sheets):** `#FFFFFF` surface with `0px 3px 6px -1px rgba(31, 41, 55, 0.08), 0px 2px 4px -1px rgba(31, 41, 55, 0.04)`.
- **Level 3 (Floating Action Controls, Bottom Sheets, Dialogs):** `#FFFFFF` surface with `0px 10px 15px -3px rgba(31, 41, 55, 0.1), 0px 4px 6px -2px rgba(31, 41, 55, 0.05)`.
- **Level 4 (Bottom Navigation Bar):** Fixed surface anchored at screen bottom using `#FFFFFF`, bordered with a top edge boundary of 1px `#E2E8DC` and an ambient directional shadow: `0px -2px 8px rgba(0, 0, 0, 0.04)`.

## Shapes

The design system employs **Roundedness Level 2** (base `0.5rem` / 8px). This geometry strikes a balance between professional industrial utility and approachable modern software:

- **Buttons, Text Inputs, and Quick Selectors:** `0.5rem` (8px) corner radius.
- **Cards, Alert Panels, and Diagnostic Cards:** `rounded-lg` at `1rem` (16px).
- **Bottom Sheets, Modals, and Elevated Banners:** `rounded-xl` at `1.5rem` (24px) for upper corners.
- **Tags, Filter Chips, and Status Pills:** Fully rounded pills (`9999px`) to visually differentiate quick-tap metadata from rectangular functional cards.

## Components

### Buttons
- **Primary:** Background `#1B5E20`, text `#FFFFFF`, height 48px, horizontal padding `space-lg`, radius 8px. Pressed state deepens to `#14532D`.
- **Secondary (Tonal):** Background `#E8F5E9`, text `#1B5E20`, height 48px, radius 8px.
- **Tertiary / Warning Action:** Background `#D97706`, text `#FFFFFF`, height 48px, radius 8px for immediate agronomic interventions.
- **Outlined:** Transparent background, 1.5px solid border `#1B5E20`, text `#1B5E20`.

### Cards & Crop Modules
- Constructed on `#FFFFFF` with a 1px border (`#D6DEC9`) and 16px radius (`rounded-lg`).
- Padding is fixed at `1rem` (16px).
- Header sections decouple titles from telemetry badges using flex alignment, maintaining clear division between diagnostic data and crop stage markers.

### Status Badges & Chips
- Status badges use pill shapes (`9999px` radius) with `0.25rem` vertical and `0.75rem` horizontal padding.
- Text uses `label-sm` (uppercase, bold).
  - **Optimal / Healthy:** Background `#E8F5E9`, text `#1B5E20`, dot indicator `#2E7D32`.
  - **Attention / Action Needed:** Background `#FEF3C7`, text `#B45309`, dot indicator `#D97706`.
  - **Critical Issue (Pest / Water Stress):** Background `#FEE2E2`, text `#B91C1C`, dot indicator `#DC2626`.
- **Filter Chips:** Height 36px, border 1px solid `#D6DEC9`, active state fills with `#E8F5E9` and border `#1B5E20`.

### Form Fields & Inputs
- Height 52px to ensure glove-friendly interaction.
- Background `#FFFFFF`, border 1px solid `#CBD5E1`, corner radius 8px.
- Focus state expands border to 2px solid `#1B5E20` with zero layout shift.
- Accompanying helper text rendered in `body-sm` (`#4B5563`).

### Checkboxes, Toggles & Radios
- Selection controls use a 24x24px active touch frame seated within a 48x48px hit target.
- Active states: Filled with `#1B5E20` containing white glyphs.
- Inactive states: 2px border outline in `#9CA3AF`.

### Lists & Telemetry Feeds
- Two-line and three-line list items separated by a hairline divider (`#E5E7EB`).
- Leading items hold standardized 40x40px rounded avatar blocks with tonal field icons; trailing areas carry numeric readouts and timestamp labels.

### Bottom Navigation Bar
- Fixed 64px tall bar on `#FFFFFF` with 1px top border `#E2E8DC`.
- 4 to 5 core destinations (e.g., Dashboard, Fields, Diagnostics, Tasks, Settings).
- Active item displays a rounded capsule indicator (`#E8F5E9`) encapsulating an icon colored in `#1B5E20`, supported by a `label-sm` title. Inactive destinations use `#6B7280`.

### Specialized Domain Component: Crop Stage Progress Tracker
- A segmented chronological step-tracker charting developmental phases (Germination, Vegetative, Flowering, Yield Formation, Ripening).
- Completed stages: Solid `#1B5E20` bar.
- Current active stage: `#2E7D32` with a pulsing amber/tertiary indicator (`#D97706`) marking ongoing AI analysis.
- Upcoming stages: `#E5E7EB`.